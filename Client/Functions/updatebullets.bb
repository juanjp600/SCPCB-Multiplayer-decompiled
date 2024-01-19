Function updatebullets%()
    Local local0.bullets
    For local0 = Each bullets
        local0\Field1 = curvevalue(1.0, local0\Field1, 5.0)
        moveentity(local0\Field0, 0.0, (-0.01 * fpsfactor), (local0\Field1 * fpsfactor))
        scaleentity(local0\Field0, 0.0003, 0.0003, ((local0\Field1 / 2.0) * fpsfactor), $00)
        entitycolor(local0\Field0, ((local0\Field1 * 10.0) * 255.0), ((local0\Field1 * 10.0) * 255.0), 0.0)
        local0\Field2 = (local0\Field2 + fpsfactor)
        If (((400.0 < local0\Field2) Or ((hidedistance * 2.0) < entitydistance(collider, local0\Field0))) <> 0) Then
            freeentity(local0\Field0)
            Delete local0
        EndIf
    Next
    Return $00
End Function
