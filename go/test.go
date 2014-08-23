package main

import "fmt"

func main() {
	m := make(map[string]int)

	m["one"] = 1
	m["two"] = 2

	fmt.Println(m)
	fmt.Println(len(m))

	v := m["two"]
	fmt.Println(v)

	delete(m, "two")
	fmt.Println(m)

	m1 := map[string]int{"one": 1, "two": 2, "three": 3}
	fmt.Println(m1)

	for key, val := range m1 {
		fmt.Printf("%s=>%d\n", key, val)
	}

	var i int = 1
	var pInt *int = &i
	fmt.Printf("i=%d\tpInt=%p\t*pInt=%d\n", i, pInt, *pInt)
}
