package serverinterface

// MyAPI You can call this struct whatever you want.
// Just make sure you use the same name in the "New" declaration below.
// And then, call this from main.go
type MyAPI struct {
}

func NewMyAPI() *MyAPI {
	return &MyAPI{}
}
