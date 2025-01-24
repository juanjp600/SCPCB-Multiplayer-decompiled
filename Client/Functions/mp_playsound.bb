Function mp_playsound%(arg0$, arg1#, arg2#, arg3%, arg4%, arg5%, arg6%, arg7#, arg8#, arg9#)
    Local local0.mp_soundchannel
    local0 = (New mp_soundchannel)
    local0\Field0 = mp_loadsound(arg0, arg5)
    If (local0\Field0 = $00) Then
        Delete local0
        Return $00
    EndIf
    local0\Field5 = createpivot($00)
    local0\Field7 = arg4
    local0\Field6 = arg3
    local0\Field2 = arg1
    local0\Field3 = arg2
    local0\Field4 = arg6
    local0\Field8 = (arg5 = $00)
    local0\Field1 = playsound(mp_getsoundhandle((Object.mp_sound local0\Field0)))
    If (ue_players[arg6] = Null) Then
        positionentity(local0\Field5, arg7, arg8, arg9, $00)
    EndIf
    mp_updatesoundchannel(local0)
    Return local0\Field1
    Return $00
End Function
