Function quickloadevents%()
    Local local0.events
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local11%
    Local local12.chunk
    If (quickload_currevent = Null) Then
        quickloadpercent = $FFFFFFFF
        Return $00
    EndIf
    catcherrors("QuickLoadEvents()")
    local0 = quickload_currevent
    Select local0\Field0
        Case $05
            If (((0.0 = local0\Field2) Lor (local0\Field13 <> "LoadDone")) <> 0) Then
                Select local0\Field13
                    Case "Load0"
                        local0\Field1\Field11[$02] = copyentity(n_i\Field0[$0A], $00)
                        local0\Field1\Field12[$02] = $01
                        quickloadpercent = $0F
                        local0\Field13 = "Load1"
                    Case "Load1"
                        local0\Field1\Field11[$03] = copyentity(n_i\Field0[$0B], $00)
                        local0\Field1\Field12[$03] = $01
                        quickloadpercent = $1E
                        local0\Field13 = "Load2"
                    Case "Load2"
                        local0\Field1\Field11[$04] = copyentity(n_i\Field0[$0C], $00)
                        local0\Field1\Field12[$04] = $01
                        quickloadpercent = $2D
                        local0\Field13 = "Load3"
                    Case "Load3"
                        local0\Field1\Field11[$05] = copyentity(n_i\Field0[$0D], $00)
                        local0\Field1\Field12[$05] = $01
                        quickloadpercent = $3C
                        local0\Field13 = "Load4"
                    Case "Load4"
                        For local5 = $02 To $05 Step $01
                            positionentity(local0\Field1\Field11[local5], entityx(local0\Field1\Field11[$00], $01), entityy(local0\Field1\Field11[$00], $01), entityz(local0\Field1\Field11[$00], $01), $01)
                            rotateentity(local0\Field1\Field11[local5], -90.0, entityyaw(local0\Field1\Field11[$00], $01), 0.0, $01)
                            scaleentity(local0\Field1\Field11[local5], 0.05, 0.05, 0.05, $01)
                        Next
                        quickloadpercent = $4B
                        local0\Field13 = "Load5"
                    Case "Load5"
                        For local5 = $02 To $05 Step $01
                            hideentity(local0\Field1\Field11[local5])
                        Next
                        quickloadpercent = $64
                        local0\Field13 = "LoadDone"
                End Select
            EndIf
        Case $49
            If (0.0 = local0\Field2) Then
                If (local0\Field13 = "Load0") Then
                    quickloadpercent = $0A
                    local0\Field1\Field11[$00] = loadmesh_strict("GFX\Map\dimension1499\1499plane.b3d", $00)
                    hideentity(local0\Field1\Field11[$00])
                    local0\Field1\Field12[$00] = $01
                    createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(getlocalstring("misc", "warning2"), $FF, $00, $00, $00)
                    createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    local0\Field13 = "Load1"
                ElseIf (local0\Field13 = "Load1") Then
                    quickloadpercent = $1E
                    i_1499\Field8 = createsky("GFX\Map\Textures\1499sky", $00)
                    local0\Field13 = "1"
                Else
                    local11 = (Int local0\Field13)
                    If (local11 < $10) Then
                        quickloadpercent = (quickloadpercent + $02)
                        local0\Field1\Field11[local11] = loadrmesh((("GFX\Map\dimension1499\dimension_1499_object(" + (Str local11)) + ").rmesh"), Null, $00)
                        scaleentity(local0\Field1\Field11[local11], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                        hideentity(local0\Field1\Field11[local11])
                        local0\Field13 = (Str (local11 + $01))
                    ElseIf (local11 = $10) Then
                        quickloadpercent = $5A
                        createchunkparts(local0\Field1)
                        local0\Field13 = "17"
                    ElseIf (local11 = $11) Then
                        quickloadpercent = $64
                        local6 = entityx(local0\Field1\Field2, $00)
                        local7 = entityy(local0\Field1\Field2, $00)
                        local8 = entityz(local0\Field1\Field2, $00)
                        For local5 = $FFFFFFFE To $00 Step $02
                            local12 = createchunk($FFFFFFFF, (((Float local5) * 2.5) * local6), local7, local8, $01)
                            local12 = createchunk($FFFFFFFF, (((Float local5) * 2.5) * local6), local7, (local8 - 40.0), $01)
                        Next
                        local0\Field2 = 2.0
                        local0\Field13 = "18"
                    EndIf
                EndIf
            EndIf
    End Select
    catcherrors((("Uncaught: QuickLoadEvents(Event Name: ID: " + (Str local0\Field0)) + ")"))
    Return $00
End Function
