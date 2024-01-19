Function voice_get_player_channels%(arg0.players)
    Local local0.records
    For local0 = Each records
        If (local0\Field7 = arg0\Field0) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
