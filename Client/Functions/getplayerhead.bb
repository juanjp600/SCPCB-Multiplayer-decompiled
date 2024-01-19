Function getplayerhead%(arg0%)
    If (((arg0 = networkserver\Field28) Or (player[arg0] = Null)) <> 0) Then
        Return camera
    EndIf
    Return player[arg0]\Field15
    Return $00
End Function
