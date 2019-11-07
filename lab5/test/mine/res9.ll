; ModuleID = 'res9.bc'
source_filename = "../test9.ll"

@sm_main = global i32 0

define void @.init.sm_main() {
  store i32 413, i32* @sm_main
  ret void
}

define void @sm_init() {
  call void @.init.sm_main()
  ret void
}
