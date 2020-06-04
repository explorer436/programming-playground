import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Fast way of searching for a string in a text file
*/

/**
* Fast comes at a price.... code complexity and perhaps readability.

Assuming that your code produces the right results now.... and it is a big assumption because:

it expects the word to be at the beginning/end of the line, or surrounded by spaces (not commas, punctuation, etc.)
it does not look for the word inside another string, it will match 'are', but not 'bare'.
OK, a much faster way (keeping it as Java), is to do the following:

Convert the search string ('are') to a byte-array in the same encoding as the file.
Open a memory-mapped byte-buffer from a File-Channel on the file.
Scan the ByteBuffer, looking for matches to the search byte-array
count the newlines as you go.
close the ByteBuffer
If the file is larger than your memory, you will have to re-position the byte-buffer occasionally. I recommend using a emopry-mapped size of about 4MB plus the size of the search-string. That way you can search the 4MB window, and then start the next window at the next 4mb boundary.

Once you get in to it, it will make sense.

This system will be fast because you will never have to copy the file's data in to Java. Everything will actually happen in the native side of things.

There is a lot to read to make it work.

StudyTrails
Yaldix
LinuxTopia
of course, if you want really fast, use grep.
*/

/**
 * why GNU grep is fast Mike Haertel mike at ducky.net Sat Aug 21 03:00:30 UTC
 * 2010 Previous message: Latest intr problems Next message: why GNU grep is
 * fast Messages sorted by: [ date ] [ thread ] [ subject ] [ author ] Hi Gabor,
 * 
 * I am the original author of GNU grep. I am also a FreeBSD user, although I
 * live on -stable (and older) and rarely pay attention to -current.
 * 
 * However, while searching the -current mailing list for an unrelated reason, I
 * stumbled across some flamage regarding BSD grep vs GNU grep performance. You
 * may have noticed that discussion too...
 * 
 * Anyway, just FYI, here's a quick summary of where GNU grep gets its speed.
 * Hopefully you can carry these ideas over to BSD grep.
 * 
 * #1 trick: GNU grep is fast because it AVOIDS LOOKING AT EVERY INPUT BYTE.
 * 
 * #2 trick: GNU grep is fast because it EXECUTES VERY FEW INSTRUCTIONS FOR EACH
 * BYTE that it *does* look at.
 * 
 * GNU grep uses the well-known Boyer-Moore algorithm, which looks first for the
 * final letter of the target string, and uses a lookup table to tell it how far
 * ahead it can skip in the input whenever it finds a non-matching character.
 * 
 * GNU grep also unrolls the inner loop of Boyer-Moore, and sets up the
 * Boyer-Moore delta table entries in such a way that it doesn't need to do the
 * loop exit test at every unrolled step. The result of this is that, in the
 * limit, GNU grep averages fewer than 3 x86 instructions executed for each
 * input byte it actually looks at (and it skips many bytes entirely).
 * 
 * See "Fast String Searching", by Andrew Hume and Daniel Sunday, in the
 * November 1991 issue of Software Practice & Experience, for a good discussion
 * of Boyer-Moore implementation tricks. It's available as a free PDF online.
 * 
 * Once you have fast search, you'll find you also need fast input.
 * 
 * GNU grep uses raw Unix input system calls and avoids copying data after
 * reading it.
 * 
 * Moreover, GNU grep AVOIDS BREAKING THE INPUT INTO LINES. Looking for newlines
 * would slow grep down by a factor of several times, because to find the
 * newlines it would have to look at every byte!
 * 
 * So instead of using line-oriented input, GNU grep reads raw data into a large
 * buffer, searches the buffer using Boyer-Moore, and only when it finds a match
 * does it go and look for the bounding newlines. (Certain command line options
 * like -n disable this optimization.)
 * 
 * Finally, when I was last the maintainer of GNU grep (15+ years ago...), GNU
 * grep also tried very hard to set things up so that the *kernel* could ALSO
 * avoid handling every byte of the input, by using mmap() instead of read() for
 * file input. At the time, using read() caused most Unix versions to do extra
 * copying. Since GNU grep passed out of my hands, it appears that use of mmap
 * became non-default, but you can still get it via --mmap. And at least in
 * cases where the data is already file system buffer caches, mmap is still
 * faster:
 * 
 * $ time sh -c 'find . -type f -print | xargs grep -l 123456789abcdef' real
 * 0m1.530s user 0m0.230s sys 0m1.357s $ time sh -c 'find . -type f -print |
 * xargs grep --mmap -l 123456789abcdef' real 0m1.201s user 0m0.330s sys
 * 0m0.929s
 * 
 * [workload was a 648 megabyte MH mail folder containing 41000 messages] So
 * even nowadays, using --mmap can be worth a >20% speedup.
 * 
 * Summary:
 * 
 * - Use Boyer-Moore (and unroll its inner loop a few times).
 * 
 * - Roll your own unbuffered input using raw system calls. Avoid copying the
 * input bytes before searching them. (Do, however, use buffered output*. The
 * normal grep scenario is that the amount of output is small compared to the
 * amount of input, so the overhead of output buffer copying is small, while
 * savings due to avoiding many small unbuffered writes can be large.)
 * 
 * - Don't look for newlines in the input until after you've found a match.
 * 
 * - Try to set things up (page-aligned buffers, page-sized read chunks,
 * optionally use mmap) so the kernel can ALSO avoid copying the bytes.
 * 
 * The key to making programs fast is to make them do practically nothing. ;-)
 * 
 * Regards,
 * 
 * Mike
 * 
 */
public class NIOGrep
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 2)
		{
			throw new IllegalArgumentException();
		}
		String grepfor = args[0];
		Path path = Paths.get(args[1]);

		String report = searchFor(grepfor, path);

		System.out.println(report);

	}

	private static final int MAPSIZE = 4 * 1024; // 4K - make this * 1024 to 4MB in a real system.

	private static String searchFor(String grepfor, Path path) throws IOException
	{
		final byte[] tosearch = grepfor.getBytes(StandardCharsets.UTF_8);
		StringBuilder report = new StringBuilder();
		int padding = 1; // need to scan 1 character ahead in case it is a word boundary.
		int linecount = 0;
		int matches = 0;
		boolean inword = false;
		boolean scantolineend = false;
		try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ))
		{
			final long length = channel.size();
			int pos = 0;
			while (pos < length)
			{
				long remaining = length - pos;
				// int conversion is safe because of a safe MAPSIZE.. Assume a reaosnably sized
				// tosearch.
				int trymap = MAPSIZE + tosearch.length + padding;
				int tomap = (int) Math.min(trymap, remaining);
				// different limits depending on whether we are the last mapped segment.
				int limit = trymap == tomap ? MAPSIZE : (tomap - tosearch.length);
				MappedByteBuffer buffer = channel.map(MapMode.READ_ONLY, pos, tomap);
				System.out.println("Mapped from " + pos + " for " + tomap);
				pos += (trymap == tomap) ? MAPSIZE : tomap;
				for (int i = 0; i < limit; i++)
				{
					final byte b = buffer.get(i);
					if (scantolineend)
					{
						if (b == '\n')
						{
							scantolineend = false;
							inword = false;
							linecount++;
						}
					}
					else if (b == '\n')
					{
						linecount++;
						inword = false;
					}
					else if (b == '\r' || b == ' ')
					{
						inword = false;
					}
					else if (!inword)
					{
						if (wordMatch(buffer, i, tomap, tosearch))
						{
							matches++;
							i += tosearch.length - 1;
							if (report.length() > 0)
							{
								report.append(", ");
							}
							report.append(linecount);
							scantolineend = true;
						}
						else
						{
							inword = true;
						}
					}
				}
			}
		}
		return "Times found at--" + matches + "\nWord found at--" + report;
	}

	private static boolean wordMatch(MappedByteBuffer buffer, int pos, int tomap, byte[] tosearch)
	{
		// assume at valid word start.
		for (int i = 0; i < tosearch.length; i++)
		{
			if (tosearch[i] != buffer.get(pos + i))
			{
				return false;
			}
		}
		byte nxt = (pos + tosearch.length) == tomap ? (byte) ' ' : buffer.get(pos + tosearch.length);
		return nxt == ' ' || nxt == '\n' || nxt == '\r';
	}
}
