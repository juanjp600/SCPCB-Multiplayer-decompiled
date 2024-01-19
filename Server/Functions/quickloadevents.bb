Function quickloadevents%()
    Local local0.events
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6.npcs
    Local local7%
    Local local8%
    Local local9#
    Local local10#
    Local local12%
    Local local13.chunk
    If (quickload_currevent = Null) Then
        quickloadpercent = $FFFFFFFF
        Return $00
    EndIf
    local0 = quickload_currevent
    Select local0\Field22
        Case $41
            If (((0.0 = local0\Field2) And (local0\Field11 <> "")) <> 0) Then
                If (((local0\Field11 <> "") And (left(local0\Field11, $04) <> "load")) <> 0) Then
                    quickloadpercent = (quickloadpercent + $05)
                    If ((Int local0\Field11) > $09) Then
                        local0\Field11 = "load2"
                    Else
                        local0\Field11 = (Str ((Int local0\Field11) + $01))
                    EndIf
                ElseIf (local0\Field11 = "load2") Then
                    local12 = $00
                    If (local0\Field1\Field30[$00] = Null) Then
                        For local6 = Each npcs
                            If (local6\Field5 = $0A) Then
                                local12 = $01
                                Exit
                            EndIf
                        Next
                        If (local12 = $00) Then
                            local0\Field1\Field30[$00] = createnpc($0A, entityx(local0\Field1\Field25[$07], $01), (entityy(local0\Field1\Field25[$07], $01) + 5.0), entityz(local0\Field1\Field25[$07], $01))
                            local0\Field1\Field30[$00]\Field66 = $01
                            positionentity(local0\Field1\Field30[$00]\Field4, entityx(local0\Field1\Field25[$07], $01), (entityy(local0\Field1\Field25[$07], $01) + 5.0), entityz(local0\Field1\Field25[$07], $01), $00)
                            resetentity(local0\Field1\Field30[$00]\Field4)
                            rotateentity(local0\Field1\Field30[$00]\Field4, 0.0, (Float (local0\Field1\Field6 + $B4)), 0.0, $00)
                            local0\Field1\Field30[$00]\Field9 = 0.0
                            local0\Field1\Field30[$00]\Field12 = $02
                            debuglog((((((Str entityx(local0\Field1\Field25[$07], $01)) + ", ") + (Str entityy(local0\Field1\Field25[$07], $01))) + ", ") + (Str entityz(local0\Field1\Field25[$07], $01))))
                        Else
                            debuglog("Skipped 049 spawning in room2sl")
                        EndIf
                    EndIf
                    quickloadpercent = $50
                    local0\Field11 = "load3"
                ElseIf (local0\Field11 = "load3") Then
                    local0\Field2 = 1.0
                    If (0.0 = local0\Field3) Then
                        local0\Field3 = -350.0
                    EndIf
                    quickloadpercent = $64
                EndIf
            EndIf
        Case $13
            local0\Field24 = $00
            If (0.0 = local0\Field2) Then
                If (local0\Field11 = "load0") Then
                    quickloadpercent = $0A
                    If (local0\Field1\Field30[$00] = Null) Then
                        local0\Field1\Field30[$00] = createnpc($04, entityx(local0\Field1\Field25[$00], $01), entityy(local0\Field1\Field25[$00], $01), entityz(local0\Field1\Field25[$00], $01))
                    EndIf
                    changenpctextureid(local0\Field1\Field30[$00], $04)
                    local0\Field11 = "load1"
                ElseIf (local0\Field11 = "load1") Then
                    quickloadpercent = $14
                    local0\Field1\Field30[$00]\Field16 = loadsound_strict("SFX\Room\Storeroom\Escape1.ogg")
                    local0\Field11 = "load2"
                ElseIf (local0\Field11 = "load2") Then
                    quickloadpercent = $23
                    local0\Field1\Field30[$00]\Field17 = playsound2(local0\Field1\Field30[$00]\Field16, camera, local0\Field1\Field30[$00]\Field4, 12.0, 1.0)
                    local0\Field11 = "load3"
                ElseIf (local0\Field11 = "load3") Then
                    quickloadpercent = $37
                    If (local0\Field1\Field30[$01] = Null) Then
                        local0\Field1\Field30[$01] = createnpc($04, entityx(local0\Field1\Field25[$01], $01), entityy(local0\Field1\Field25[$01], $01), entityz(local0\Field1\Field25[$01], $01))
                    EndIf
                    changenpctextureid(local0\Field1\Field30[$01], $02)
                    local0\Field11 = "load4"
                ElseIf (local0\Field11 = "load4") Then
                    quickloadpercent = $50
                    local0\Field1\Field30[$01]\Field16 = loadsound_strict("SFX\Room\Storeroom\Escape2.ogg")
                    local0\Field11 = "load5"
                ElseIf (local0\Field11 = "load5") Then
                    quickloadpercent = $64
                    pointentity(local0\Field1\Field30[$00]\Field4, local0\Field1\Field30[$01]\Field4, 0.0)
                    pointentity(local0\Field1\Field30[$01]\Field4, local0\Field1\Field30[$00]\Field4, 0.0)
                    local0\Field2 = 1.0
                EndIf
            EndIf
        Case $27
            If (0.0 = local0\Field2) Then
                If (local0\Field11 = "load0") Then
                    local6 = createnpc($0B, entityx(local0\Field1\Field25[$04], $01), entityy(local0\Field1\Field25[$04], $01), entityz(local0\Field1\Field25[$04], $01))
                    pointentity(local6\Field4, local0\Field1\Field2, 0.0)
                    turnentity(local6\Field4, 0.0, 190.0, 0.0, $00)
                    quickloadpercent = $14
                    local0\Field11 = "load1"
                ElseIf (local0\Field11 = "load1") Then
                    local6 = createnpc($0B, entityx(local0\Field1\Field25[$05], $01), entityy(local0\Field1\Field25[$05], $01), entityz(local0\Field1\Field25[$05], $01))
                    pointentity(local6\Field4, local0\Field1\Field2, 0.0)
                    turnentity(local6\Field4, 0.0, 20.0, 0.0, $00)
                    quickloadpercent = $3C
                    local0\Field11 = "load2"
                ElseIf (local0\Field11 = "load2") Then
                    For local6 = Each npcs
                        If (local6\Field5 = $0A) Then
                            local0\Field1\Field30[$00] = local6
                            local0\Field1\Field30[$00]\Field9 = 2.0
                            local0\Field1\Field30[$00]\Field24 = 1.0
                            local0\Field1\Field30[$00]\Field66 = $01
                            positionentity(local0\Field1\Field30[$00]\Field4, entityx(local0\Field1\Field25[$04], $01), (entityy(local0\Field1\Field25[$04], $01) + 3.0), entityz(local0\Field1\Field25[$04], $01), $00)
                            resetentity(local0\Field1\Field30[$00]\Field4)
                            Exit
                        EndIf
                    Next
                    If (local0\Field1\Field30[$00] = Null) Then
                        local6 = createnpc($0A, entityx(local0\Field1\Field25[$04], $01), (entityy(local0\Field1\Field25[$04], $01) + 3.0), entityz(local0\Field1\Field25[$04], $01))
                        pointentity(local6\Field4, local0\Field1\Field2, 0.0)
                        local6\Field9 = 2.0
                        local6\Field24 = 1.0
                        local6\Field66 = $01
                        local0\Field1\Field30[$00] = local6
                    EndIf
                    quickloadpercent = $64
                    local0\Field2 = 1.0
                EndIf
            EndIf
        Case $38
            If (((0.0 = local0\Field2) Or (local0\Field1\Field25[$00] = $00)) <> 0) Then
                If (local0\Field11 = "load0") Then
                    local0\Field1\Field25[$03] = loadanimmesh_strict("GFX\npcs\205_demon1.b3d", $00)
                    quickloadpercent = $0A
                    local0\Field11 = "load1"
                ElseIf (local0\Field11 = "load1") Then
                    local0\Field1\Field25[$04] = loadanimmesh_strict("GFX\npcs\205_demon2.b3d", $00)
                    quickloadpercent = $14
                    local0\Field11 = "load2"
                ElseIf (local0\Field11 = "load2") Then
                    local0\Field1\Field25[$05] = loadanimmesh_strict("GFX\npcs\205_demon3.b3d", $00)
                    quickloadpercent = $1E
                    local0\Field11 = "load3"
                ElseIf (local0\Field11 = "load3") Then
                    local0\Field1\Field25[$06] = loadanimmesh_strict("GFX\npcs\205_woman.b3d", $00)
                    quickloadpercent = $28
                    local0\Field11 = "load4"
                ElseIf (local0\Field11 = "load4") Then
                    quickloadpercent = $32
                    local0\Field11 = "load5"
                ElseIf (local0\Field11 = "load5") Then
                    For local8 = $03 To $06 Step $01
                        positionentity(local0\Field1\Field25[local8], entityx(local0\Field1\Field25[$00], $01), entityy(local0\Field1\Field25[$00], $01), entityz(local0\Field1\Field25[$00], $01), $01)
                        rotateentity(local0\Field1\Field25[local8], -90.0, entityyaw(local0\Field1\Field25[$00], $01), 0.0, $01)
                        scaleentity(local0\Field1\Field25[local8], 0.05, 0.05, 0.05, $01)
                    Next
                    quickloadpercent = $46
                    local0\Field11 = "load6"
                ElseIf (local0\Field11 = "load6") Then
                    hideentity(local0\Field1\Field25[$03])
                    hideentity(local0\Field1\Field25[$04])
                    hideentity(local0\Field1\Field25[$05])
                    quickloadpercent = $64
                    local0\Field11 = "loaddone"
                    debuglog("LOADED ROOM 205!")
                EndIf
            EndIf
        Case $39
            If (local0\Field11 = "load0") Then
                quickloadpercent = $0F
                forestnpc = createsprite($00)
                scalesprite(forestnpc, (1.0 / 3.904762), 0.75)
                spriteviewmode(forestnpc, $04)
                entityfx(forestnpc, $09)
                forestnpctex = loadanimtexture("GFX\npcs\AgentIJ.AIJ", $03, $8C, $19A, $00, $04)
                forestnpcdata[$00] = 0.0
                entitytexture(forestnpc, forestnpctex, (Int forestnpcdata[$00]), $00)
                forestnpcdata[$01] = 0.0
                forestnpcdata[$02] = 0.0
                hideentity(forestnpc)
                local0\Field11 = "load1"
            ElseIf (local0\Field11 = "load1") Then
                quickloadpercent = $28
                local0\Field11 = "load2"
            ElseIf (local0\Field11 = "load2") Then
                quickloadpercent = $64
                If (local0\Field1\Field30[$00] = Null) Then
                    local0\Field1\Field30[$00] = createnpc($0E, 0.0, 0.0, 0.0)
                EndIf
                local0\Field11 = "loaddone"
            EndIf
        Case $3A
            If (1.0 = local0\Field2) Then
                local0\Field3 = (local0\Field3 + fpsfactor)
                If (30.0 < local0\Field3) Then
                    If (local0\Field11 = "") Then
                        createnpc($12, entityx(local0\Field1\Field25[$00], $01), entityy(local0\Field1\Field25[$00], $01), entityz(local0\Field1\Field25[$00], $01))
                        quickloadpercent = $32
                        local0\Field11 = "load0"
                    ElseIf (local0\Field11 = "load0") Then
                        createnpc($12, entityx(local0\Field1\Field25[$02], $01), entityy(local0\Field1\Field25[$02], $01), entityz(local0\Field1\Field25[$02], $01))
                        quickloadpercent = $64
                        local0\Field2 = 2.0
                    EndIf
                Else
                    quickloadpercent = (Int local0\Field3)
                EndIf
            EndIf
        Case $3E
            If (0.0 = local0\Field2) Then
                If (local0\Field11 = "load0") Then
                    quickloadpercent = $0A
                    local0\Field1\Field25[$00] = loadmesh_strict("GFX\map\dimension1499\1499plane.b3d", $00)
                    hideentity(local0\Field1\Field25[$00])
                    local0\Field11 = "load1"
                ElseIf (local0\Field11 = "load1") Then
                    quickloadpercent = $1E
                    local0\Field11 = "1"
                ElseIf ((Int local0\Field11) < $10) Then
                    quickloadpercent = (quickloadpercent + $02)
                    local0\Field1\Field25[(Int local0\Field11)] = loadmesh_strict((("GFX\map\dimension1499\1499object" + (Str (Int local0\Field11))) + ".b3d"), $00)
                    hideentity(local0\Field1\Field25[(Int local0\Field11)])
                    local0\Field11 = (Str ((Int local0\Field11) + $01))
                ElseIf ((Int local0\Field11) = $10) Then
                    quickloadpercent = $5A
                    createchunkparts(local0\Field1)
                    local0\Field11 = "17"
                ElseIf ((Int local0\Field11) = $11) Then
                    quickloadpercent = $64
                    local9 = entityx(local0\Field1\Field2, $00)
                    local10 = entityz(local0\Field1\Field2, $00)
                    For local8 = $FFFFFFFE To $00 Step $02
                        local13 = createchunk($FFFFFFFF, (((Float local8) * 2.5) * local9), entityy(local0\Field1\Field2, $00), local10, $01)
                    Next
                    For local8 = $FFFFFFFE To $00 Step $02
                        local13 = createchunk($FFFFFFFF, (((Float local8) * 2.5) * local9), entityy(local0\Field1\Field2, $00), (local10 - 40.0), $01)
                    Next
                    local0\Field2 = 2.0
                    local0\Field11 = "18"
                EndIf
            EndIf
    End Select
    If (quickloadpercent = $00) Then
        quickloadpercent = $FFFFFFFF
        quickload_currevent = Null
    EndIf
    Return $00
End Function
