Function getfreeplayerindex%()
    Local local0%
    For local0 = $01 To $78 Step $01
        If (ue_players[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
    Return $00
End Function
