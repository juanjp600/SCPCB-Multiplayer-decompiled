Function server_fillownplayerdata%(arg0.mp_player)
    mp_writebyte(arg0\Field4\Field4)
    mp_writeshort(convertfloattoshort(arg0\Field4\Field6, 10.0))
    mp_writeshort(convertfloattoshort(arg0\Field4\Field7, 10.0))
    mp_writeshort(convertfloattoshort(arg0\Field4\Field10, 10.0))
    mp_writeshort(convertfloattoshort(arg0\Field4\Field11, 10.0))
    mp_writeshort(convertfloattoshort(arg0\Field4\Field13, 10.0))
    mp_writeshort(convertfloattoshort(arg0\Field4\Field12, 10.0))
    mp_writeshort((Int arg0\Field4\Field9))
    mp_writeshort((Int arg0\Field4\Field30))
    mp_writeshort((Int arg0\Field4\Field31))
    mp_writebyte(arg0\Field4\Field34)
    Return $00
End Function
