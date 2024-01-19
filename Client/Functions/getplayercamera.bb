Function getplayercamera%(arg0%)
    If (arg0 = networkserver\Field28) Then
        Return camera
    EndIf
    If (player[arg0] = Null) Then
        Return camera
    EndIf
    Return player[arg0]\Field14
    Return $00
End Function
