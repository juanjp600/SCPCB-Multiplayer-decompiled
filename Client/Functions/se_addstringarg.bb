Function se_addstringarg%(arg0$)
    se_arguments_stack_level = (se_arguments_stack_level + $01)
    se_arguments_number = (se_arguments_number + $01)
    se_growarguments()
    se_arguments_stack((se_arguments_stack_level - $01))\Field0 = $03
    se_arguments_stack((se_arguments_stack_level - $01))\Field3 = arg0
    Return $00
End Function
