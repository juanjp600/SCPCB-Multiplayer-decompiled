Function getplayerzone%(arg0%)
    Local local0.rooms
    If (player[arg0] <> Null) Then
        For local0 = Each rooms
            If (local0\Field69 = player[arg0]\Field32) Then
                Return local0\Field0
            EndIf
        Next
    EndIf
    Return $00
End Function
