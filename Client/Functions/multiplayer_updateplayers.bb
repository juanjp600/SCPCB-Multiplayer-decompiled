Function multiplayer_updateplayers%()
    Local local0.players
    For local0 = Each players
        If (local0\Field0 <> networkserver\Field28) Then
            multiplayer_updateplayer(local0)
            multiplayer_updateplayerobjects(local0)
            If (local0\Field15 <> $00) Then
                multiplayer_updateplayerragdolls(local0)
                multiplayer_updateplayeranimations(local0)
                multiplayer_manipulateplayerbones(local0)
                multiplayer_updateattachplayers(local0)
            EndIf
        EndIf
        multiplayer_updateplayermicrohid(local0)
        multiplayer_updateplayersounds(local0)
    Next
    Return $00
End Function
