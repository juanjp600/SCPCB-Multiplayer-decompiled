Function raycastitems%()
    Local local0.rooms
    Local local1.items
    For local0 = Each rooms
        showroomsnocoll(local0)
    Next
    For local1 = Each items
        entitypickmode(local1\Field2, $00, $01)
        If (((local1\Field15 = $00) And (linepick(entityx(local1\Field2, $00), entityy(local1\Field2, $00), entityz(local1\Field2, $00), 0.0, -5.0, 0.0, 0.0) <> $00)) <> 0) Then
            positionentity(local1\Field2, entityx(local1\Field2, $00), (pickedy() + 0.011), entityz(local1\Field2, $00), $00)
            resetentity(local1\Field2)
            local1\Field24 = $01
            local1\Field22 = $00
        EndIf
        entitypickmode(local1\Field2, $01, $00)
    Next
    For local0 = Each rooms
        hideroomsnocoll(local0)
    Next
    Return $00
End Function
