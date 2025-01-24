.lib "freeimage.dll"

fi_load%(arg0%, arg1$, arg2%):"_FreeImage_Load@12"
fi_save%(arg0%, arg1%, arg2$, arg3%):"_FreeImage_Save@16"
fi_unload%(arg0%):"_FreeImage_Unload@4"
fi_getfiffromfilename%(arg0$):"_FreeImage_GetFIFFromFilename@4"
fi_convertfromrawbits%(arg0*, arg1%, arg2%, arg3%, arg4%, arg5%, arg6%, arg7%, arg8%):"_FreeImage_ConvertFromRawBits@36"
fi_rescale%(arg0%, arg1%, arg2%, arg3%):"_FreeImage_Rescale@16"
