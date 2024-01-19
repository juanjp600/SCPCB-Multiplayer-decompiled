Function createrocket.rockets(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%)
    Local local0.rockets
    local0 = (New rockets)
    local0\Field7 = arg4
    local0\Field8 = arg5
    local0\Field1 = createpivot($00)
    positionentity(local0\Field1, arg1, (arg2 + 0.2), arg3, $00)
    rotateentity(local0\Field1, arg4, arg5, 0.0, $00)
    resetentity(local0\Field1)
    moveentity(local0\Field1, 0.1, -0.17, 0.0)
    local0\Field11 = arg6
    If (player[arg6] <> Null) Then
        local0\Field12 = player[arg6]\Field36
    EndIf
    Return local0
    Return Null
End Function
