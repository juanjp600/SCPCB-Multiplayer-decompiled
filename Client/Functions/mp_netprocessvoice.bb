Function mp_netprocessvoice%()
    Local local0%
    If (mp_isconnected() = $00) Then
        Return $00
    EndIf
    If (mp_getvoicebuffer() <> $00) Then
        If (mp_ishoster() <> 0) Then
            mp_serverbroadcastvoice(ue_players[mp_getmyindex()], 180.0, mp_getvoicebuffer(), myplayerlogic\Field2)
        Else
            mp_broadcastvoice(getnetworkserverip(), getnetworkserverport(), mp_getmyindex(), mp_getvoicebuffer(), $00)
        EndIf
    EndIf
    If (((keydown(key\Field14) And (mp_voice\Field6 = $00)) And (((ismultiplayerhudenabled Lor menuopen) Lor consoleopen) = $00)) <> 0) Then
        mp_voice\Field4 = (mp_gettimer() + $FA)
    EndIf
    local0 = (mp_voice\Field4 > mp_gettimer())
    mp_setvoicerecording(local0)
    Return $00
End Function
