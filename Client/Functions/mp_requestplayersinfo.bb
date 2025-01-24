Function mp_requestplayersinfo%()
    Local local0.mp_player
    Local local1%
    If ((mp_ishoster() Lor (mp_isconnected() = $00)) <> 0) Then
        Return $00
    EndIf
    If (determinepacketflooding(ue_players[mp_getmyindex()], $00, $01, $FA) <> 0) Then
        Return $00
    EndIf
    local1 = $00
    For local0 = Each mp_player
        If (local0\Field17 <> local0\Field16) Then
            local1 = (local1 + $01)
        EndIf
    Next
    If (local1 > $00) Then
        mp_writebyte($09)
        mp_writebyte(mp_getmyindex())
        mp_writebyte($01)
        mp_writebyte($00)
        For local0 = Each mp_player
            If (local0\Field17 <> local0\Field16) Then
                mp_writebyte(local0\Field5)
            EndIf
        Next
        mp_writebyte($00)
        mp_sendtoserver()
    EndIf
    Return $00
End Function
