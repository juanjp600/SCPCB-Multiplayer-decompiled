Function getscreenshot%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    If (filetype("Screenshots\") <> $02) Then
        createdir("Screenshots")
    EndIf
    local2 = createbank(((opt\Field49 * opt\Field50) * $03))
    local3 = backbuffer()
    lockbuffer(local3)
    For local0 = $00 To (opt\Field49 - $01) Step $01
        For local1 = $00 To (opt\Field50 - $01) Step $01
            local4 = readpixelfast(local0, local1, local3)
            local5 = (((opt\Field49 * $03) * local1) + (local0 * $03))
            pokebyte(local2, local5, readpixelcolor(local4, $00))
            pokebyte(local2, (local5 + $01), readpixelcolor(local4, $08))
            pokebyte(local2, (local5 + $02), readpixelcolor(local4, $10))
        Next
    Next
    unlockbuffer(local3)
    local6 = fi_convertfromrawbits(local2, opt\Field49, opt\Field50, (opt\Field49 * $03), $18, $FF0000, $FF00, $FF, $01)
    fi_save($0D, local6, (("Screenshots\Screenshot" + (Str screenshotcount)) + ".png"), $00)
    fi_unload(local6)
    local6 = $00
    freebank(local2)
    local2 = $00
    If (mainmenuopen = $00) Then
        createhintmsg(getlocalstring("msg", "screenshot"), 6.0, $00)
    EndIf
    playsound_strict(loadtempsound("SFX\General\Screenshot.ogg"), $00, $01)
    screenshotcount = (screenshotcount + $01)
    Return $00
End Function
