Function renderblur%(arg0#)
    entityalpha(arkblurimage, arg0)
    copyrect($00, $00, opt\Field49, opt\Field50, (Int (smallest_power_two_half - (Float mo\Field9))), (Int (smallest_power_two_half - (Float mo\Field10))), backbuffer(), texturebuffer(arkblurtexture, $00))
    Return $00
End Function
