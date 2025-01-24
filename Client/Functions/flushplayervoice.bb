Function flushplayervoice%(arg0.mp_player)
    bass_streamfree(arg0\Field36\Field0[$00])
    bass_streamfree(arg0\Field36\Field0[$01])
    Delete arg0\Field36
    Return $00
End Function
