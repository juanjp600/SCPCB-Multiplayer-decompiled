Function updatedimension1499%()
    Local local0%
    Local local1.events
    Local local2%
    Local local3%
    Local local4%
    Local local5.items
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    local0 = $01
    If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) <> 0) Then
        local0 = $00
    EndIf
    If (local0 <> 0) Then
        Return $00
    EndIf
    local1 = dimension1499
    If (local1 = Null) Then
        Return $00
    EndIf
    local1\Field13 = collider
    local1\Field20 = calculatedist(local1\Field13, local1\Field1)
    If (playerroom = local1\Field1) Then
        If (2.0 > local1\Field2) Then
            If (0.0 = local1\Field2) Then
                If (((local1\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                    quickloadpercent = $00
                    quickload_currevent = local1
                    local1\Field11 = "load0"
                EndIf
            Else
                local1\Field2 = 2.0
            EndIf
        EndIf
        camerafogrange(camera, 0.5, 30.0)
        camerafogcolor(camera, 96.0, 97.0, 104.0)
        cameraclscolor(camera, 96.0, 97.0, 104.0, 1.0)
        camerarange(camera, 0.02, 30.0)
        showentity(local1\Field1\Field3)
        If (((quickloadpercent = $64) Or (quickloadpercent = $FFFFFFFF)) <> 0) Then
            updatechunks(local1\Field1, $0F, $01)
            showentity(sky[$02])
            update2dsky($02)
            shouldplay = $12
            If (800.0 > entityy(local1\Field13, $00)) Then
                positionentity(local1\Field13, entityx(local1\Field13, $00), 800.5, entityz(local1\Field13, $00), $01)
                resetentity(local1\Field13)
            EndIf
            For local5 = Each items
                If (750.0 < entityy(local5\Field2, $00)) Then
                    If (800.0 > entityy(local5\Field2, $00)) Then
                        positionentity(local5\Field2, entityx(local5\Field2, $00), 800.5, entityz(local5\Field2, $00), $00)
                        resetentity(local5\Field2)
                    EndIf
                EndIf
            Next
            If (8.4375 > (Abs (entityx(local1\Field13, $00) - (local1\Field1\Field4 - 0.21875)))) Then
                If (5.5 > (Abs (entityz(local1\Field13, $00) - (local1\Field1\Field6 + 8.933594)))) Then
                    shouldplay = $42
                EndIf
            EndIf
        Else
            dropspeed = 0.0
        EndIf
        currstepsfx = $03
        playerfallingpickdistance = 0.0
    ElseIf (2.0 = local1\Field2) Then
        If (local1\Field5 <> $00) Then
            stopstream_strict(local1\Field5)
            stopchannel(local1\Field6)
            local1\Field5 = $00
            local1\Field6 = $00
        EndIf
        hideentity(sky[$02])
        hidechunks()
        If (2100.0 > local1\Field4) Then
            local1\Field4 = 0.0
        EndIf
        local1\Field2 = 1.0
        If (local1\Field8 <> $00) Then
            freesound_strict(local1\Field8)
            local1\Field8 = $00
        EndIf
    EndIf
    Return $00
End Function
