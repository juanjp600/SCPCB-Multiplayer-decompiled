Function multiplayer_updateobjects%()
    Local local0.multiplayer_objects
    For local0 = Each multiplayer_objects
        If (local0\Field1 <> $00) Then
            positionentity(local0\Field1, curvevalue(local0\Field3, entityx(local0\Field1, $00), (Float local0\Field9)), curvevalue(local0\Field4, entityy(local0\Field1, $00), (Float local0\Field9)), curvevalue(local0\Field5, entityz(local0\Field1, $00), (Float local0\Field9)), $00)
            If (0.005 <= distance3(local0\Field3, local0\Field4, local0\Field5, entityx(local0\Field1, $00), entityy(local0\Field1, $00), entityz(local0\Field1, $00))) Then
                resetentity(local0\Field1)
            EndIf
            rotateentity(local0\Field1, curveangle(local0\Field6, entitypitch(local0\Field1, $00), (Float local0\Field9)), curveangle(local0\Field7, entityyaw(local0\Field1, $00), (Float local0\Field9)), curveangle(local0\Field8, entityroll(local0\Field1, $00), (Float local0\Field9)), $00)
        EndIf
    Next
    Return $00
End Function
