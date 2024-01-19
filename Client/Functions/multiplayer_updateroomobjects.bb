Function multiplayer_updateroomobjects%()
    Local local0%
    If (playerroom = Null) Then
        Return $00
    EndIf
    If (grabbedentity <> $00) Then
        For local0 = $00 To $1D Step $01
            If (grabbedentity = playerroom\Field25[local0]) Then
                If (networkserver\Field18 <> 0) Then
                    playerroom\Field26[local0] = $00
                Else
                    multiplayer_writeplayerroomobject(grabbedentity, local0)
                EndIf
            EndIf
        Next
    EndIf
    Return $00
End Function
