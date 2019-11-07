; ModuleID = 'result/test0.res'
source_filename = "../../../docker_dir/test/test0.ll"

@sm_main = global i32 0

define void @.init.sm_main() {
  store i32 5, i32* @sm_main
  ret void
}

define void @sm_init() {
  call void @.init.sm_main()
  ret void
}
