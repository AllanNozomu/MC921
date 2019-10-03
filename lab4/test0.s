	.text
	.file	"test0.ll"
	.type	sm_main,@object         # @sm_main
	.data
	.globl	sm_main
	.align	4
sm_main:
	.long	5                       # 0x5
	.size	sm_main, 4


	.section	".note.GNU-stack","",@progbits
