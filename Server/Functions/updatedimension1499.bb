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
    Local local12#
    Local local13%
    Local local14#
    Local local15.chunk
    Local local16.players
    Local local17%
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
    If (local1\Field1\Field25[$00] = $00) Then
        local1\Field1\Field25[$00] = loadmesh_strict("GFX\map\dimension1499\1499plane.b3d", $00)
        hideentity(local1\Field1\Field25[$00])
        local1\Field11 = "1"
        While (local1\Field11 <> "18")
            If ((Int local1\Field11) < $10) Then
                local1\Field1\Field25[(Int local1\Field11)] = loadmesh_strict((("GFX\map\dimension1499\1499object" + (Str (Int local1\Field11))) + ".b3d"), $00)
                hideentity(local1\Field1\Field25[(Int local1\Field11)])
                local1\Field11 = (Str ((Int local1\Field11) + $01))
            ElseIf ((Int local1\Field11) = $10) Then
                createchunkparts(local1\Field1)
                local1\Field11 = "17"
            ElseIf ((Int local1\Field11) = $11) Then
                local12 = entityx(local1\Field1\Field2, $00)
                local14 = entityz(local1\Field1\Field2, $00)
                For local6 = $FFFFFFFE To $00 Step $02
                    local15 = createchunk($FFFFFFFF, (((Float local6) * 2.5) * local12), entityy(local1\Field1\Field2, $00), local14, $01)
                Next
                For local6 = $FFFFFFFE To $00 Step $02
                    local15 = createchunk($FFFFFFFF, (((Float local6) * 2.5) * local12), entityy(local1\Field1\Field2, $00), (local14 - 40.0), $01)
                Next
                local1\Field2 = 2.0
                local1\Field11 = "18"
            EndIf
        Wend
        local1\Field11 = ""
    EndIf
    If (playerinroom(local1) <> 0) Then
        For local5 = Each items
            If (750.0 < entityy(local5\Field1, $00)) Then
                If (800.0 > entityy(local5\Field1, $00)) Then
                    positionentity(local5\Field1, entityx(local5\Field1, $00), 800.5, entityz(local5\Field1, $00), $00)
                    resetentity(local5\Field1)
                EndIf
            EndIf
        Next
    ElseIf (2.0 = local1\Field2) Then
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
    If (((quickloadpercent = $64) Or (quickloadpercent = $FFFFFFFF)) <> 0) Then
        hideentity(local1\Field1\Field2)
        For local16 = Each players
            If (local16\Field32 = local1\Field1\Field69) Then
                showentity(local1\Field1\Field2)
                updatechunks(local1\Field1, $0F, $01, local16\Field62, local16)
                local17 = $12
                If (800.0 > entityy(local16\Field62, $00)) Then
                    positionentity(local16\Field62, entityx(local16\Field62, $00), 800.5, entityz(local16\Field62, $00), $01)
                    resetentity(local16\Field62)
                EndIf
            EndIf
        Next
    EndIf
    Return $00
End Function
