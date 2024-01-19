Function updatedecals%()
    Local local0.decals
    Local local1%
    Local local2#
    Local local3#
    Local local4.decals
    For local0 = Each decals
        If (0.0 <> local0\Field1) Then
            local0\Field2 = (local0\Field2 + (local0\Field1 * fpsfactor))
            scalesprite(local0\Field0, local0\Field2, local0\Field2)
            local1 = local0\Field8
            If (local1 = $00) Then
                If (0.0 >= local0\Field9) Then
                    local2 = (Float rand($168, $01))
                    local3 = rnd(local0\Field2, 0.0)
                    local4 = createdecal($01, (entityx(local0\Field0, $00) + (cos(local2) * local3)), (entityy(local0\Field0, $00) - 0.0005), (entityz(local0\Field0, $00) + (sin(local2) * local3)), entitypitch(local0\Field0, $00), rnd(360.0, 0.0), entityroll(local0\Field0, $00))
                    local4\Field2 = rnd(0.1, 0.5)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    playsound2(decaysfx(rand($01, $03)), camera, local4\Field0, 10.0, rnd(0.1, 0.5))
                    local0\Field9 = (Float rand($32, $64))
                Else
                    local0\Field9 = (local0\Field9 - fpsfactor)
                EndIf
            EndIf
            If (local0\Field3 <= local0\Field2) Then
                local0\Field1 = 0.0
                local0\Field2 = local0\Field3
            EndIf
        EndIf
        If (0.0 <> local0\Field4) Then
            local0\Field5 = min((local0\Field5 + (local0\Field4 * fpsfactor)), 1.0)
            entityalpha(local0\Field0, local0\Field5)
        EndIf
        If (0.0 < local0\Field10) Then
            local0\Field10 = max((local0\Field10 - fpsfactor), 5.0)
        EndIf
        If (hidedistance < entitydistance(local0\Field0, collider)) Then
            hideentity(local0\Field0)
        Else
            showentity(local0\Field0)
        EndIf
        If ((((0.0 >= local0\Field2) Or (0.0 >= local0\Field5)) Or (5.0 = local0\Field10)) <> 0) Then
            freeentity(local0\Field0)
            Delete local0
        EndIf
    Next
    Return $00
End Function
