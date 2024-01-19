Function rcon_kick%(arg0$)
    Local local0.players
    For local0 = Each players
        If (local0\Field15 = arg0) Then
            kick(local0\Field30, (("[RCON] " + local0\Field15) + " has been kicked."))
        EndIf
    Next
    Return $00
End Function
