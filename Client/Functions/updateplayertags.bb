Function updateplayertags%(arg0.mp_player)
    Local local0#
    Local local1#
    Local local2%
    Local local3.mp_playertag
    Local local4#
    Local local5#
    If (arg0\Field5 = mp_getmyindex()) Then
        Return $00
    EndIf
    local0 = 4.0
    local1 = 9.0
    For local2 = $00 To $04 Step $01
        local3 = arg0\Field34[local2]
        If (local3\Field8 <> 0) Then
            applyplayertagattributes(arg0, local2)
            local3\Field8 = $00
        EndIf
        If (local3\Field1 <> $00) Then
            If (((local1 >= entitydistancesquared(arg0\Field18, me\Field60)) And (arg0\Field30 = $00)) <> 0) Then
                If (entityhidden(local3\Field1) <> 0) Then
                    showentity(local3\Field1)
                EndIf
                local4 = entitydistancesquared(local3\Field1, camera)
                local5 = (clamp((1.0 - ((local4 - local0) / max((local1 - local0), 0.0001))), 0.0, 1.0) * (1.0 - ((Float arg0\Field27) * 0.7)))
                If (local1 <= local4) Then
                    local5 = 0.0
                EndIf
                positionentity(local3\Field1, 0.0, (local3\Field5 - ((Float arg0\Field27) * 0.2)), 0.0, $00)
                entityalpha(local3\Field1, local5)
            ElseIf (entityhidden(local3\Field1) = $00) Then
                hideentity(local3\Field1)
            EndIf
        EndIf
    Next
    Return $00
End Function
