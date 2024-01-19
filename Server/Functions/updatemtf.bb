Function updatemtf%()
    Local local0.rooms
    Local local1.npcs
    Local local2%
    Local local3%
    Local local4.rooms
    Local local5.players
    Local local6.npcs
    Local local7.items
    If (0.0 = mtftimer) Then
        If (rand($1E, $01) = $01) Then
            local4 = Null
            For local0 = Each rooms
                If (local0\Field7\Field10 = "gateaentrance") Then
                    local4 = local0
                    Exit
                EndIf
            Next
            If (local4 <> Null) Then
                For local5 = Each players
                    If ((((((0.0 <> local5\Field0) Or (0.0 <> local5\Field1)) Or (0.0 <> local5\Field2)) And local5\Field22) And (local5\Field32 <> $00)) <> 0) Then
                        If ((((local5\Field67 <> "pocketdimension") And (local5\Field67 <> "dimension1499")) And (local5\Field67 <> "")) <> 0) Then
                            If (30.0 > (Abs (entityz(local4\Field2, $00) - entityz(local5\Field62, $00)))) Then
                                mtftimer = fpsfactor
                                playannouncement("SFX\Character\MTF\Announc.ogg", $01)
                                For local3 = $00 To $02 Step $01
                                    local1 = createnpc($08, (entityx(local4\Field2, $00) + (0.3 * (Float (local3 - $01)))), 1.0, (entityz(local4\Field2, $00) + 8.0))
                                    If (local3 = $00) Then
                                        local6 = local1
                                    Else
                                        local1\Field47 = local6
                                    EndIf
                                    local1\Field78 = $01
                                    local1\Field28 = (Float local3)
                                Next
                                Return $00
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        EndIf
    ElseIf (8400.0 >= mtftimer) Then
        mtftimer = (mtftimer + fpsfactor)
    ElseIf (((8400.0 < mtftimer) And (10000.0 > mtftimer)) <> 0) Then
        playannouncement("SFX\Character\MTF\AnnouncAfter1.ogg", $01)
        mtftimer = 10000.0
    ElseIf (((10000.0 <= mtftimer) And (18400.0 >= mtftimer)) <> 0) Then
        mtftimer = (mtftimer + fpsfactor)
    ElseIf (((18400.0 < mtftimer) And (20000.0 > mtftimer)) <> 0) Then
        playannouncement("SFX\Character\MTF\AnnouncAfter2.ogg", $01)
        mtftimer = 20000.0
    ElseIf (((20000.0 <= mtftimer) And (24200.0 >= mtftimer)) <> 0) Then
        mtftimer = (mtftimer + fpsfactor)
    ElseIf (((24200.0 < mtftimer) And (25000.0 > mtftimer)) <> 0) Then
        For local7 = Each items
            If (local7\Field22 <> $00) Then
                If ((((left(local7\Field3\Field1, $04) = "SCP-") And (left(local7\Field3\Field1, $07) <> "SCP-035")) And (left(local7\Field3\Field1, $07) <> "SCP-093")) <> 0) Then
                    playannouncement("SFX\Character\MTF\ThreatAnnouncPossession.ogg", $01)
                    mtftimer = 25000.0
                    Return $00
                EndIf
            EndIf
        Next
        playannouncement((("SFX\Character\MTF\ThreatAnnounc" + (Str rand($01, $03))) + ".ogg"), $01)
        mtftimer = 25000.0
    ElseIf (((25000.0 <= mtftimer) And (29200.0 >= mtftimer)) <> 0) Then
        mtftimer = (mtftimer + fpsfactor)
    ElseIf (((29200.0 < mtftimer) And (30000.0 > mtftimer)) <> 0) Then
        playannouncement("SFX\Character\MTF\ThreatAnnouncFinal.ogg", $01)
        mtftimer = 30000.0
    EndIf
    Return $00
End Function
