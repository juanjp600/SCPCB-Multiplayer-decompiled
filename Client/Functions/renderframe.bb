Function renderframe%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%, arg6%)
    Local local0%
    If (arg6 <> 0) Then
        local0 = menugray
    Else
        local0 = menuwhite
    EndIf
    rendertiledimagerect(local0, arg4, arg5, $200, $200, arg0, arg1, arg2, arg3)
    rendertiledimagerect(menublack, arg4, arg5, $200, $200, (Int ((3.0 * menuscale) + (Float arg0))), (Int ((3.0 * menuscale) + (Float arg1))), (Int ((Float arg2) - (6.0 * menuscale))), (Int ((Float arg3) - (6.0 * menuscale))))
    Return $00
End Function
