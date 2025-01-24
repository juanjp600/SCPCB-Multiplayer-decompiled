Function updatemtf%()
    Local local0.rooms
    Local local1%
    Local local2%
    Local local3.rooms
    Local local4%
    If (((playerroom\Field7\Field6 = $46) Lor ((mp_getsocket() <> $00) And (mp_ishoster() = $00))) <> 0) Then
        Return $00
    EndIf
    If (0.0 = mtftimer) Then
        If (((rand($C8, $01) = $01) And (playerroom\Field7\Field6 <> $6A)) <> 0) Then
            local3 = Null
            For local0 = Each rooms
                If (local0\Field7\Field6 = $46) Then
                    local3 = local0
                    Exit
                EndIf
            Next
            If (local3 <> Null) Then
                If (me\Field59 = $02) Then
                    playannouncement("SFX\Character\MTF\AnnouncEnter.ogg", $01)
                    mtftimer = fps\Field7[$00]
                    For local2 = $00 To $02 Step $01
                        createnpc($15, (entityx(local3\Field30, $01) + (0.3 * (Float (local2 - $01)))), 0.28, entityz(local3\Field30, $01))
                    Next
                EndIf
            EndIf
        EndIf
    ElseIf (8400.0 >= mtftimer) Then
        mtftimer = (fps\Field7[$00] + mtftimer)
    ElseIf (((8400.0 < mtftimer) And (10000.0 > mtftimer)) <> 0) Then
        playannouncement("SFX\Character\MTF\AnnouncAfter0.ogg", $01)
        mtftimer = 10000.0
    ElseIf (((10000.0 <= mtftimer) And (18400.0 >= mtftimer)) <> 0) Then
        mtftimer = (fps\Field7[$00] + mtftimer)
    ElseIf (((18400.0 < mtftimer) And (20000.0 > mtftimer)) <> 0) Then
        playannouncement("SFX\Character\MTF\AnnouncAfter1.ogg", $01)
        mtftimer = 20000.0
    ElseIf (((20000.0 <= mtftimer) And (24200.0 >= mtftimer)) <> 0) Then
        mtftimer = (fps\Field7[$00] + mtftimer)
    ElseIf (((24200.0 < mtftimer) And (25000.0 > mtftimer)) <> 0) Then
        local4 = $00
        For local2 = $00 To (maxitemamount - $01) Step $01
            If (inventory(local2) <> Null) Then
                If ((((left(inventory(local2)\Field4\Field1, $04) = "SCP-") And (left(inventory(local2)\Field4\Field1, $07) <> "SCP-035")) And (left(inventory(local2)\Field4\Field1, $07) <> "SCP-093")) <> 0) Then
                    local4 = $01
                    Exit
                EndIf
            EndIf
        Next
        If (local4 <> 0) Then
            playannouncement("SFX\Character\MTF\AnnouncThreatPossession.ogg", $01)
        Else
            playannouncement((("SFX\Character\MTF\AnnouncThreat" + (Str rand($00, $02))) + ".ogg"), $01)
        EndIf
        mtftimer = 25000.0
    ElseIf (((25000.0 <= mtftimer) And (29200.0 >= mtftimer)) <> 0) Then
        mtftimer = (fps\Field7[$00] + mtftimer)
    ElseIf (((29200.0 < mtftimer) And (30000.0 > mtftimer)) <> 0) Then
        playannouncement("SFX\Character\MTF\AnnouncThreatFinal.ogg", $01)
        mtftimer = 30000.0
    EndIf
    Return $00
End Function
