Function mp_playlocalsound%(arg0$, arg1#, arg2%)
    Local local0%
    Local local1.mp_localsoundchannel
    local0 = mp_loadsound(arg0, arg2)
    If (local0 = $00) Then
        Return $00
    EndIf
    local1 = (New mp_localsoundchannel)
    local1\Field0 = local0
    local1\Field2 = arg1
    local1\Field1 = playsound(mp_getsoundhandle((Object.mp_sound local1\Field0)))
    local1\Field3 = (arg2 = $00)
    channelvolume(local1\Field1, (opt\Field20 * arg1))
    Return local1\Field1
    Return $00
End Function
