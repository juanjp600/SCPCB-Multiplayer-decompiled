Function updatebutton%(arg0%)
    Local local0#
    Local local1%
    local0 = entitydistancesquared(camera, arg0)
    If (0.64 > local0) Then
        local1 = createpivot($00)
        positionentity(local1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local1, arg0, 0.0)
        If (entitypick(local1, 0.8) = arg0) Then
            d_i\Field9 = arg0
            freeentity(local1)
            local1 = $00
            Return $01
        EndIf
        freeentity(local1)
        local1 = $00
    EndIf
    Return $00
    Return $00
End Function
