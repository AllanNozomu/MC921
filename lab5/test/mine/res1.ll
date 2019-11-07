; ModuleID = 'res1.bc'
source_filename = "../test1.ll"

@sm_main = global i32 0

define i32 @a(i32 %x) {
  ret i32 %x
}

define void @.init.sm_main() {
  %.0 = call i32 @a(i32 10)
  store i32 %.0, i32* @sm_main
  ret void
}

define void @sm_init() {
  call void @.init.sm_main()
  ret void
}
