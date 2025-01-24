Function teleportentity%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5%, arg6#, arg7%)
    Local local0%
    local0 = createpivot($00)
    positionentity(local0, arg1, (arg2 + 0.05), arg3, arg5)
    rotateentity(local0, ((Float ($01 - (arg7 Shl $01))) * 90.0), 0.0, 0.0, $00)
    If (entitypick(local0, arg6) <> $00) Then
        positionentity(arg0, arg1, ((pickedy() + arg4) + ((Float ($01 - (arg7 Shl $01))) * 0.02)), arg3, arg5)
    Else
        positionentity(arg0, arg1, arg2, arg3, arg5)
    EndIf
    freeentity(local0)
    local0 = $00
    resetentity(arg0)
    Return $00
End Function
