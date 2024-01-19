Function drawclickabletext%(arg0%, arg1%, arg2$, arg3%, arg4%, arg5%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    local0 = colorred()
    local1 = colorgreen()
    local2 = colorblue()
    local3 = $00
    If (mouseon(arg0, arg1, aastringwidth(arg2), aastringheight(arg2)) <> 0) Then
        color(arg3, arg4, arg5)
        If (mousehit1 <> 0) Then
            local3 = $01
        EndIf
    EndIf
    aatext(arg0, arg1, arg2, $00, $00, 1.0)
    color(local0, local1, local2)
    Return local3
    Return $00
End Function
