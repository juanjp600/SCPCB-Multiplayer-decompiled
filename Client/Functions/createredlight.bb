Function createredlight%(arg0#, arg1#, arg2#)
    Local local0%
    local0 = createsprite($00)
    positionentity(local0, arg0, arg1, arg2, $00)
    scalesprite(local0, 0.015, 0.015)
    entitytexture(local0, misc_i\Field2[$01], $00, $00)
    entityblend(local0, $03)
    Return local0
    Return $00
End Function
