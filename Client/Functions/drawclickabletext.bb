Function drawclickabletext%(arg0%, arg1%, arg2$, arg3%, arg4%, arg5%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    local0 = colorredex()
    local1 = colorgreenex()
    local2 = colorblueex()
    local3 = $00
    If (mouseon(arg0, arg1, stringwidth(arg2), stringheight(arg2)) <> 0) Then
        setcolorex(arg3, arg4, arg5)
        If (mousehit1 <> 0) Then
            local3 = $01
        EndIf
    EndIf
    text(arg0, arg1, arg2, $00, $00)
    setcolorex(local0, local1, local2)
    Return local3
    Return $00
End Function
