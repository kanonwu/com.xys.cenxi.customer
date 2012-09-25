package com.xys.cenxi.customer.ui.component.provider;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.xys.cenxi.customer.data.RatingService;
import com.xys.cenxi.customer.data.query.QueryRateResultKey;
import com.xys.cenxi.customer.pojo.query.QRateResultInfo;

/**
 * ���ֲ�ѯ�����������ṩ����RateResultQueryKey ��Ϊ��������
 * @author wjl
 *
 */
public class QRateResultTableProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement == null){
			return null;
		}
		
		if(inputElement instanceof QueryRateResultKey){
			QueryRateResultKey key = (QueryRateResultKey) inputElement;
			//��ѯ����
			List<QRateResultInfo> result = RatingService.getInstance().query(key);
			return result.toArray();
		}
		
		return null;
	}

}
