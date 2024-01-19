Function updatebutton%(arg0%)
    Local local0#
    Local local1%
    local0 = entitydistance(collider, arg0)
    If (0.8 > local0) Then
        entitypickmode(arg0, $02, $01)
        local1 = createpivot($00)
        positionentity(local1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local1, arg0, 0.0)
        If (entitypick(local1, 0.65) = arg0) Then
            If (closestbutton = $00) Then
                closestbutton = arg0
            ElseIf (local0 < entitydistance(collider, closestbutton)) Then
                closestbutton = arg0
            EndIf
        EndIf
        entitypickmode(arg0, $00, $01)
        freeentity(local1)
    EndIf
    Return $00
End Function
