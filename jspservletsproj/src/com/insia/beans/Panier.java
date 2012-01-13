package com.insia.beans;

import com.insia.models.Articles;


public class Panier {
		private Articles item;
		private int qte;
		
		public Panier(){

		}

		/**
		 * @return the item
		 */
		public Articles getItem() {
			return item;
		}

		/**
		 * @param item the item to set
		 */
		public void setItem(Articles item) {
			this.item = item;
		}

		/**
		 * @return the qte
		 */
		public int getQte() {
			return qte;
		}

		/**
		 * @param qte the qte to set
		 */
		public void setQte(int qte) {
			this.qte = qte;
		}


		
		
	}
