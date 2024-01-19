Function takefalldamage%(arg0#)
    injuries = (injuries + arg0)
    channelvolume(playsound_strict(loadtempsound("SFX\General\BodyFall.ogg")), (0.5 * sfxvolume))
    multiplayer_writetempsound("SFX\General\BodyFall.ogg", 0.0, 0.0, 0.0, 10.0, 1.0)
    Return $00
End Function
