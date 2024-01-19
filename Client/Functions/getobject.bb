Function getobject%(arg0.events)
    If (player[arg0\Field14] = Null) Then
        Return collider
    EndIf
    Return player[arg0\Field14]\Field13
    Return $00
End Function
