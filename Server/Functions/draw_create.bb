Function draw_create%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%, arg6%, arg7$)
    Local local0%
    local0 = draw_getid(arg0)
    If (local0 = $00) Then
        Return $00
    EndIf
    player[arg0]\Field43[local0] = (New draws)
    player[arg0]\Field43[local0]\Field1 = arg7
    player[arg0]\Field43[local0]\Field3 = arg1
    player[arg0]\Field43[local0]\Field4 = arg2
    player[arg0]\Field43[local0]\Field5 = arg3
    player[arg0]\Field43[local0]\Field6 = arg4
    player[arg0]\Field43[local0]\Field2 = arg5
    player[arg0]\Field43[local0]\Field7 = arg6
    player[arg0]\Field43[local0]\Field8 = ((len(arg7) + $01) + $15)
    player[arg0]\Field51 = (player[arg0]\Field51 + $01)
    Return local0
    Return $00
End Function
