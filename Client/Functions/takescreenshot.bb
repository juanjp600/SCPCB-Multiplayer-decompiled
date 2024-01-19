Function takescreenshot%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    If (filetype("screens") <> $02) Then
        createdir("screens")
    EndIf
    Repeat
        If (filesize((("screens\scpmp-" + (Str local0)) + ".png")) = $00) Then
            local1 = createbank(((realgraphicwidth * realgraphicheight) * $03))
            If (local1 <> $00) Then
                lockbuffer(backbuffer())
                For local2 = $00 To (realgraphicwidth - $01) Step $01
                    For local3 = $00 To (realgraphicheight - $01) Step $01
                        local4 = readpixelfast(local2, local3, backbuffer())
                        pokebyte(local1, (((realgraphicwidth * $03) * local3) + (local2 * $03)), ((local4 Shr $00) And $FF))
                        pokebyte(local1, ((((realgraphicwidth * $03) * local3) + (local2 * $03)) + $01), ((local4 Shr $08) And $FF))
                        pokebyte(local1, ((((realgraphicwidth * $03) * local3) + (local2 * $03)) + $02), ((local4 Shr $10) And $FF))
                    Next
                Next
                unlockbuffer(backbuffer())
                local5 = fi_convertfromrawbits(local1, realgraphicwidth, realgraphicheight, (realgraphicwidth * $03), $18, $FF0000, $FF00, $FF, $01)
                fi_save($0D, local5, (("screens\scpmp-" + (Str local0)) + ".png"), $00)
                fi_unload(local5)
                freebank(local1)
                multiplayer_addchatmsg((("Screenshot taken in screens\scpmp-" + (Str local0)) + ".png"), $00)
            EndIf
            Exit
        EndIf
        local0 = (local0 + $01)
    Forever
    Return $00
End Function
