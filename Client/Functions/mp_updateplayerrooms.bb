Function mp_updateplayerrooms%()
    Local local0.mp_player
    If (mp_ishoster() = $00) Then
        Return $00
    EndIf
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            mp_updateplayerroom(local0)
        EndIf
    Next
    Return $00
End Function
