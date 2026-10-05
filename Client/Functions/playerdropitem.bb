Function playerdropitem%(arg0.items)
    arg0\Field16 = $00
    positionentity(arg0\Field2, player[arg0\Field22]\Field1, (player[arg0\Field22]\Field2 + 0.7), player[arg0\Field22]\Field3, $01)
    resetentity(arg0\Field2)
    rotateentity(arg0\Field2, 0.0, (entityyaw(player[arg0\Field22]\Field13, $00) + rnd(-110.0, 110.0)), 0.0, $00)
    moveentity(arg0\Field2, 0.0, -0.1, 0.1)
    arg0\Field22 = $00
    If (arg0\Field1\Field2 = "clipboard") Then
        arg0\Field17 = arg0\Field1\Field9
        setanimtime(arg0\Field3, 17.0, $00)
    ElseIf (arg0\Field1\Field2 = "wallet") Then
        setanimtime(arg0\Field3, 0.0, $00)
    EndIf
    Return $00
End Function
