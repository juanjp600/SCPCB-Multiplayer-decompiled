Function rendergamma%()
    Local local0#
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    If (1.0 < opt\Field6) Then
        local0 = (1.0 / graphicwidthfloat)
        local1 = (smallest_power_two / graphicwidthfloat)
        copyrect($00, $00, opt\Field46, opt\Field47, (Int (smallest_power_two_half - (Float mo\Field9))), (Int (smallest_power_two_half - (Float mo\Field10))), backbuffer(), texturebuffer(fresizetexture, $00))
        entityblend(fresizeimage, $01)
        clscolor($00, $00, $00)
        cls()
        scalerender((- local0), local0, local1, local1)
        entityfx(fresizeimage, $21)
        entityblend(fresizeimage, $03)
        entityalpha(fresizeimage, (opt\Field6 - 1.0))
        scalerender((- local0), local0, local1, local1)
    ElseIf (1.0 > opt\Field6) Then
        local0 = (1.0 / graphicwidthfloat)
        local1 = (smallest_power_two / graphicwidthfloat)
        local2 = (Int (opt\Field6 * 255.0))
        local3 = backbuffer()
        local4 = texturebuffer(fresizetexture2, $00)
        copyrect($00, $00, opt\Field46, opt\Field47, (Int (smallest_power_two_half - (Float mo\Field9))), (Int (smallest_power_two_half - (Float mo\Field10))), local3, texturebuffer(fresizetexture, $00))
        entityblend(fresizeimage, $01)
        clscolor($00, $00, $00)
        cls()
        scalerender((- local0), local0, local1, local1)
        entityfx(fresizeimage, $21)
        entityblend(fresizeimage, $02)
        entityalpha(fresizeimage, 1.0)
        setbuffer(local4)
        clscolor(local2, local2, local2)
        cls()
        setbuffer(local3)
        scalerender((- local0), local0, local1, local1)
        setbuffer(local4)
        clscolor($00, $00, $00)
        cls()
        setbuffer(local3)
    EndIf
    entityfx(fresizeimage, $01)
    entityblend(fresizeimage, $01)
    entityalpha(fresizeimage, 1.0)
    Return $00
End Function
