Function updateplayerspivot%()
    Local local0.mp_player
    Local local1#
    Local local2#
    Local local3#
    For local0 = Each mp_player
        updateplayerlogic(local0)
        If (((local0\Field18 <> $00) And (local0\Field5 <> mp_getmyindex())) <> 0) Then
            local0\Field13 = curveangle(local0\Field11, local0\Field13, 4.0)
            local0\Field12 = curvevalue(local0\Field10, local0\Field12, 4.0)
            If (4.0 > distancesquared(entityx(local0\Field18, $00), local0\Field7, entityy(local0\Field18, $00), local0\Field8, entityz(local0\Field18, $00), local0\Field9)) Then
                local1 = entityx(local0\Field18, $00)
                local2 = entityy(local0\Field18, $00)
                local3 = entityz(local0\Field18, $00)
                positionentity(local0\Field18, curvevalue(local0\Field7, entityx(local0\Field18, $00), 4.0), curvevalue(local0\Field8, entityy(local0\Field18, $00), 4.0), curvevalue(local0\Field9, entityz(local0\Field18, $00), 4.0), $00)
                local0\Field23 = distance(local1, entityx(local0\Field18, $00), local2, entityy(local0\Field18, $00), local3, entityz(local0\Field18, $00))
            Else
                positionentity(local0\Field18, local0\Field7, local0\Field8, local0\Field9, $00)
            EndIf
            resetentity(local0\Field18)
            rotateentity(local0\Field18, 0.0, local0\Field13, 0.0, $00)
            rotateentity(local0\Field19, local0\Field12, local0\Field13, 0.0, $01)
            updateplayertags(local0)
        EndIf
    Next
    Return $00
End Function
