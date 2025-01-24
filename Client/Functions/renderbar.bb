Function renderbar%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5#, arg6#, arg7%, arg8%, arg9%)
    Local local0%
    Local local1%
    rect(arg1, arg2, (Int ((4.0 * menuscale) + (Float arg3))), arg4, $00)
    If (opt\Field38 <> 0) Then
        color(arg7, arg8, arg9)
        rect((Int ((3.0 * menuscale) + (Float arg1))), (Int ((3.0 * menuscale) + (Float arg2))), (Int (((Float arg3) - (2.0 * menuscale)) * (arg5 / arg6))), (Int ((Float arg4) - (6.0 * menuscale))), $01)
    Else
        local1 = (Int ((((Float arg3) - (2.0 * menuscale)) * ((arg5 / arg6) / 10.0)) / menuscale))
        For local0 = $01 To local1 Step $01
            drawblock(arg0, (Int (((Float (((local0 - $01) * $0A) + $03)) * menuscale) + (Float arg1))), (Int ((3.0 * menuscale) + (Float arg2))), $00)
        Next
    EndIf
    Return $00
End Function
